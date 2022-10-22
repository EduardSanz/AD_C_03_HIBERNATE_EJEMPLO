package com.cieep;

import com.cieep.modelos.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("qwert", "ertyu", "123456");

        // Genero la variable que lee el archivo de configuración
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Creo la sesión de conexión a la BD
        Session session = sessionFactory.openSession();
        // Activo la transacción para la secuencia de las acciones SQL
        session.beginTransaction();

        // CREATE
        session.persist(alumno);
        // READ
/*        Alumno a = session.get(Alumno.class, 1);
        System.out.println(a.toString());
        // UPDATE
        a.setNombre("Eduard");
        session.merge(a);
        // DELETE
        session.remove(a);*/


        // Lanza las instrucciones SQL
        session.getTransaction().commit();
        session.close();
    }
}