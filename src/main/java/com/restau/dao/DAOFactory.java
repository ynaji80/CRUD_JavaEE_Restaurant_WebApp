package com.restau.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {


    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "user";
    private static final String PROPERTY_MOT_DE_PASSE    = "password";

    private String   url;
    private String   username;
    private String   password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws com.restau.dao.DAOConfigurationException {
        Properties properties = new Properties();
        String url = "jdbc:mysql://localhost:3306/miniproject_db";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "root";

        try {
            System.out.println(url);
            System.out.println(driver);
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new com.restau.dao.DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, user, password );
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    /* package */ Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    public static void releaseConnection(Connection con){
        try {
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /*
     * Méthodes de récupération de l'implémentation des différents DAO (un seul
     * pour le moment)
     */
    public RestaurantDAO getRestaurantDAO() throws SQLException {
        return new RestaurantDaoImp(this, this.getConnection());
    }


}