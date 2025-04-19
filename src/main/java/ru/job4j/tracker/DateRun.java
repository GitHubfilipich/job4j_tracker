package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.TimeZone;

public class DateRun {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    /*.withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))*/
                    .openSession();

            /*session.beginTransaction();
            var item = new Item();
            item.setName("check timezone new Europe/Moscow");
            LocalDateTime nowUtc = ZonedDateTime
                    .now(ZoneId.systemDefault())       // локальная зона
                    *//*.now(ZoneId.of("Europe/Moscow"))       // выбранная зона*//*
                    .withZoneSameInstant(ZoneId.of("UTC")) // переводим в UTC
                    .toLocalDateTime();
            item.setCreated(nowUtc);
            session.persist(item);
            session.getTransaction().commit();*/

            var stored = session.createQuery(
                    "from Item", Item.class
            ).list();
            for (Item it : stored) {
                System.out.println("+++");
                System.out.println(it.getCreated());
                var time = it.getCreated().atZone(
                        ZoneId.of("UTC+10")
                ).format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
                System.out.println(time);
                /*System.out.println(ZonedDateTime.of(it.getCreated(),
                        ZoneId.of("America/Los_Angeles")));*/
                /*LocalDateTime nowUtc = ZonedDateTime
                        .now(ZoneId.systemDefault())       // локальная зона
                        .withZoneSameInstant(ZoneId.of("UTC")) // переводим в UTC
                        .toLocalDateTime();*/
                /*// Считаем, что время сохранено в UTC:
                ZonedDateTime utcZoned = it.getCreated().atZone(ZoneId.of("UTC"));
                // Переводим в зону пользователя, например, Europe/Moscow
                ZonedDateTime userZoned = utcZoned.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
                // Если нужно снова получить LocalDateTime для отображения:
                LocalDateTime displayTime = userZoned.toLocalDateTime();*/
                String zoneId = "Europe/Moscow";
                System.out.println(zoneId + " : " + it.getCreated().atZone(ZoneId.of("UTC")).
                        withZoneSameInstant(ZoneId.of(zoneId)).
                        toLocalDateTime());
                zoneId = "America/Los_Angeles";
                System.out.println(zoneId + " : " + it.getCreated().atZone(ZoneId.of("UTC")).
                        withZoneSameInstant(ZoneId.of(zoneId)).
                        toLocalDateTime());
            }
            session.close();

            /*var zones = new ArrayList<TimeZone>();
            System.out.println("++++++++++ timeId +++++++++++");
            for (String timeId : TimeZone.getAvailableIDs()) {
                zones.add(TimeZone.getTimeZone(timeId));
                System.out.println(timeId);
            }
            System.out.println("++++++++++ zone.getID() + \" : \" + zone.getDisplayName() +++++++++++");
            zones.stream().sorted(Comparator.comparing(TimeZone::getID))
                    .forEachOrdered(timeZone -> System.out.println(timeZone.getID() + " : " + timeZone.getDisplayName()));*/

            var zones = new ArrayList<TimeZone>();
            System.out.println("++++++++++ ZoneId.getAvailableZoneIds() +++++++++++");
            for (String timeId : ZoneId.getAvailableZoneIds()) {
                zones.add(TimeZone.getTimeZone(timeId));
                System.out.println(timeId);
            }

            printZones();

            /*for (TimeZone zone : zones) {
                System.out.println(zone.getID() + " : " + zone.getDisplayName());
            }*/

            System.out.println("+++++++++ TimeZone.getDefault(); ++++++++++++++");
            var defTz = TimeZone.getDefault();
            int offset = defTz.getRawOffset() / 1000;
            int offsetHours = offset / (60 * 60);
            int offsetMinutes = Math.abs((offset / 60) % 60);
            System.out.println(defTz.getID() + " : (UTC " + String.format("%+03d:%02d", offsetHours, offsetMinutes)
                    + ") " + defTz.getDisplayName());

            ZoneId zoneId = ZoneId.of("Europe/Belgrade");
            ZonedDateTime nowInZone = ZonedDateTime.now(zoneId);
            String off = nowInZone.getOffset().getId();
            System.out.println("Europe/Belgrade" + off);

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void printZones() {
        ZoneId.getAvailableZoneIds().stream()
                .map(id -> {
                    ZoneId zoneId = ZoneId.of(id);
                    return id + " : (UTC " + ZonedDateTime.now(zoneId).getOffset().getId() + ") "
                            + TimeZone.getTimeZone(zoneId).getDisplayName();
                })
                .sorted()
                .forEachOrdered(System.out::println);
    }
}

