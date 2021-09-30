package lab.assist.constants;

public final class AppConstant {
    public static final String ARTICLE_TABLE = "articles";
    public static final String USERS_TABLE = "users";

    public static final String TEXT_ARTICLES_NAME_COLUMN = "textArticles";

    public static final String MESSAGE_ATTR = "message";
    public static final String ARTICLES_ATTR = "articles";
    public static final String ARTICLE_ATTR = "article";
    public static final String USER_ATTR = "user";
    public static final String USER_ID_ATTR = "user_id";
    public static final String USER_JSP_ATTR = "userJSP";

    public static final String IDS_PARAM = "ids";
    public static final String ID_DYNAMIC_PARAM = "/{id}";

    public static final String USER_ID_COL = "userID";
    public static final String ARTICLE_ID_COL = "articleID";
    public static final String ID_COL = "id";
    public static final String HEADER_COL = "header";
    public static final String SHORT_DESCRIPTION_COL = "shortDescription";
    public static final String TEXT_ARTICLES_COL = "textArticle";
    public static final String DATE_CREATE_COL = "dateCreate";
    public static final String AUTHOR_COL = "author";
    public static final String LOGIN_COL = "login";
    public static final String PASSWORD_COL = "password";

    public static final String AUTHORIZATION_URL = "/authorization";
    public static final String RECORD_ARTICLE_URL = "/recordArticle";
    public static final String REGISTRATION_URL = "/registration";
    public static final String SHOW_ARTICLE_URL = "/showArticle";
    public static final String LOG_OUT_URL = "/logOut";
    public static final String EDIT_ARTICLE_URL = "/editArticle";
    public static final String DELETE_URL = "/deleteArticle";

    public static final String MAIN_PATH = "main";
    public static final String REGISTRATION_PATH = "registration";
    public static final String FULL_ARTICLE_PATH = "fullArticle";
    public static final String NOT_FOUND_PATH = "notfound";

    public static final String USER_NOT_FOUND_MESSAGE = "User not found. Incorrect login or password.";
    public static final String USER_HAVE_ALREADY_MESSAGE = "This user have already";
    public static final String USER_PARAMS_IS_EMPTY_MESSAGE = "Some params is empty!!!";
    public static final String ARTICLES_PARAMS_IS_EMPTY_MESSAGE = "Some params is empty!!! gotta full their...";

    public static final String INSERT_ARTICLE_QUERY = "insert into articles " +
            "(header, shortDescription, textArticles, dateCreate, author) values (:header, :shortDescription, :textArticle, :dateCreate, :author)";

    public static final String UPDATE_ARTICLE_FROM_ARTICLES_QUERY = "update articles set header=:header, shortDescription=:shortDescription, " +
            "textArticles=:textArticle, dateCreate=:dateCreate, author=:author where id=:id";

    public static final String INSERT_USER_QUERY = "insert into users (login, password) values (:login, :password)";

    public static final String SELECT_ONE_ARTICLE_BY_PARAMS_QUERY = "select * from articles where " +
            "header=:header and shortDescription=:shortDescription and textArticles=:textArticle and dateCreate=:dateCreate and author=:author";
}
