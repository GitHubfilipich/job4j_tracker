package ru.job4j.tracker;

import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class RestServer {

    private final Javalin app;

    public RestServer(Store consoleApp, int port) {
         /*Настройка Jackson для сериализации объектов в JSON*/
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules(); // поддержка LocalDate, LocalDateTime и т.п.
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

         /*Создание Javalin с подключением JSON-маппера*/
        this.app = Javalin.create(config -> config.jsonMapper(new JavalinJackson(mapper)));

        configureRoutes(consoleApp);

         /*Запуск сервера*/
        app.start(port);
    }

    private void configureRoutes(Store consoleApp) {
         /*Получить все элементы*/
        app.get("/items", ctx -> {
            List<Item> items = consoleApp.findAll();
            ctx.json(items);
        });

         /*Получить элемент по id*/
        app.get("/items/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Item item = consoleApp.findById(id);
            if (item != null) {
                ctx.json(item);
            } else {
                ctx.status(404).result("Item not found");
            }
        });

         /*Создать новый элемент*/
        app.post("/items", ctx -> {
            Item item = ctx.bodyAsClass(Item.class);
            consoleApp.add(item);
            ctx.status(201).json(item);
        });

         /*Обновить существующий элемент*/
        app.put("/items/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Item item = ctx.bodyAsClass(Item.class);
            boolean updated = consoleApp.replace(id, item);
            if (updated) {
                ctx.json(item);
            } else {
                ctx.status(404).result("Item not found");
            }
        });

         /*Удалить элемент*/
        app.delete("/items/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            try {
                consoleApp.delete(id);
            } catch (Exception e) {
                ctx.status(404).result("Item not found");
                return;
            }
            ctx.result("Deleted");
        });

         /*Логируем все исключения*/
        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
            ctx.status(500).json(new ErrorResponse("Internal Server Error", e.getMessage()));
        });

         /*Логируем 404*/
        app.error(404, ctx -> {
            System.out.println("404 Not Found: " + ctx.path());
            ctx.json(new ErrorResponse("Not Found", "Path " + ctx.path() + " does not exist"));
        });
    }

    /**
     * Остановка сервера.
     * Вызывать при завершении программы или через shutdown hook.
     */
    public void stop() {
        app.stop();
    }
}