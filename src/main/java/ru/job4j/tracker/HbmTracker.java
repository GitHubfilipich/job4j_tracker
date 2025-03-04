package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            return item;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Item persistItem = session.get(Item.class, id);
            if (persistItem != null) {
                persistItem.setName(item.getName());
                persistItem.setCreated(item.getCreated());
                session.save(persistItem);
                session.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        return session.createQuery("from Item", Item.class)
                .list();
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        return session.createQuery("from Item WHERE name LIKE :fName", Item.class)
                .setParameter("fName", "%" + key + "%")
                .list();
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        return session.get(Item.class, id);
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
