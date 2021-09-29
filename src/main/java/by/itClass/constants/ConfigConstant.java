package by.itClass.constants;

public final class ConfigConstant {
    public static final String ROOT_MAPPING = "/";

    public static final String VIEW_RESOLVER_PREFIX = "/view/";
    public static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    public static final String MAIN_PACKAGES = "by.itClass";
    public static final String ENTITY_PACKAGE = MAIN_PACKAGES + ".model.entity";
    public static final String REPOSITORY_PACKAGE = MAIN_PACKAGES + ".model.repositories";

    public static final String  DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String  DB_URL = "jdbc:mysql://localhost:3306/myspace?serverTimezone=Europe/Minsk";
    public static final String  DB_USER_NAME = "Bahish";
    public static final String  DB_PASSWORD = "tadam";
}
