import java.util.Scanner;

abstract class Application {
    protected String name;
    protected String developer;
    protected double version;
    protected static int appCount = 0;
    
    public Application(String name, String developer, double version) {
        this.name = name;
        this.developer = developer;
        this.version = version;
        appCount++;
    }
    
    public abstract void displayInfo();
    public abstract void performMainFunction();
    
    public void updateVersion(double newVersion) {
        this.version = newVersion;
        System.out.println(name + " обновлен до версии " + newVersion);
    }
    
    public String getName() { return name; }
    public String getDeveloper() { return developer; }
    public double getVersion() { return version; }
    public static int getAppCount() { return appCount; }
}

class SocialNetwork extends Application {
    private int userCount;
    
    public SocialNetwork(String name, String developer, double version, int userCount) {
        super(name, developer, version);
        this.userCount = userCount;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Соцсеть: " + name);
        System.out.println("Разработчик: " + developer);
        System.out.println("Версия: " + version);
        System.out.println("Пользователей: " + userCount);
    }
    
    @Override
    public void performMainFunction() {
        System.out.println(name + ": Обмен сообщениями");
    }
    
    public void addUser() {
        userCount++;
        System.out.println("Новый пользователь! Всего: " + userCount);
    }
}

class Game extends Application {
    private String genre;
    private boolean isMultiplayer;
    
    public Game(String name, String developer, double version, String genre, boolean isMultiplayer) {
        super(name, developer, version);
        this.genre = genre;
        this.isMultiplayer = isMultiplayer;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Игра: " + name);
        System.out.println("Разработчик: " + developer);
        System.out.println("Версия: " + version);
        System.out.println("Жанр: " + genre);
        System.out.println("Мультиплеер: " + (isMultiplayer ? "Да" : "Нет"));
    }
    
    @Override
    public void performMainFunction() {
        System.out.println(name + ": Запуск игры");
    }
    
    public void startGame() {
        System.out.println("Запускаем " + name + "...");
    }
}

class WeatherApp extends Application {
    private String location;
    
    public WeatherApp(String name, String developer, double version, String location) {
        super(name, developer, version);
        this.location = location;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Погода: " + name);
        System.out.println("Разработчик: " + developer);
        System.out.println("Версия: " + version);
        System.out.println("Город: " + location);
    }
    
    @Override
    public void performMainFunction() {
        System.out.println(name + ": Показ погоды для " + location);
    }
    
    public void updateWeather() {
        System.out.println("Обновляем погоду для " + location);
    }
}

public class LabWorkApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Простая демонстрация приложений ===\n");
        
        SocialNetwork vk = new SocialNetwork("VK", "VK Team", 5.0, 10000000);
        Game minecraft = new Game("Minecraft", "Mojang", 1.19, "Песочница", true);
        WeatherApp weather = new WeatherApp("Яндекс.Погода", "Yandex", 3.5, "Москва");
        
        Application[] apps = {vk, minecraft, weather};
        
        for (Application app : apps) {
            app.displayInfo();
            app.performMainFunction();
            System.out.println("---");
        }
        
        System.out.println("Всего приложений создано: " + Application.getAppCount());
        
        System.out.println("\n=== Специфичные методы ===");
        vk.addUser();
        minecraft.startGame();
        weather.updateWeather();
        
        System.out.println("\n=== Обновление версии ===");
        vk.updateVersion(5.1);
        vk.displayInfo();
        
        System.out.println("\n=== Создание своего приложения ===");
        System.out.print("Введите название соцсети: ");
        String name = scanner.nextLine();
        
        System.out.print("Введите количество пользователей: ");
        int users = scanner.nextInt();
        
        SocialNetwork userApp = new SocialNetwork(name, "Пользователь", 1.0, users);
        userApp.displayInfo();
        userApp.addUser();
        
        System.out.println("Всего приложений теперь: " + Application.getAppCount());
        
        scanner.close();
    }
}