import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

abstract class AbstractforCemetery {
    protected ArrayList<String> vskrit = new ArrayList<>();
    protected ArrayList<String> kremc = new ArrayList<>();
    protected ArrayList<String> firee = new ArrayList<>();
    protected int[][] places = new int[3][3];
    protected ArrayList<String> employees = new ArrayList<>();

    protected abstract void initializePlaces();
    protected abstract void initializeEmployees();

    public abstract void enterCemetery();
    public abstract void actions();
    protected abstract void showServices();
    protected abstract void flours();
    protected abstract void showPlaces();
    protected abstract void cleanGrave();
    protected abstract void vskritie();
    protected abstract void krem();
    protected abstract void fire();
    protected abstract void horon();
    protected abstract void exitCemetery();
}

class Cemetry extends AbstractforCemetery {
    static Log my_log;

    static {
        try{
            my_log = new Log("Cemetery.log", Level.ALL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Cemetry() {
        initializePlaces();
        initializeEmployees();
    }

    class Chtoto extends Cemetry{
        static Log my_log;

        static {
            try{
                my_log = new Log("Logger.log");
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void initializePlaces() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                places[i][j] = count++;
            }
        }
    }

    @Override
    protected void initializeEmployees() {
        employees.add("Михаил Евгеньевич Нокинов - 28 лет");
        employees.add("Эдуард Андреевич Климов - 67 лет");
    }

    @Override
    public void enterCemetery() {
        System.out.println("Хотите войти на кладбище?\n1. Да\n2. Нет");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.println("Добро пожаловать на кладбище братишка!");
                actions();
                break;
            case "2":
                break;
        }
    }

    @Override
    public void actions() {
        System.out.println("Что вы хотите увидеть?\n1. Список работников\n2. Платные услуги\n3. Выйти из кладбища");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.println(employees);
                break;
            case "2":
                showServices();
                break;
            case "3":
                exitCemetery();
                break;
        }
    }

    @Override
    protected void showServices() {
        System.out.println("Вот все услуги, выбирай:\n1. Поставить цветы\n2. Убраться на могиле\n3. Вывод мест" +
                "\n4. Вскрытие\n5. Кремировать\n6. Сожжение (ведьму желательно, но можно кого угодно)\n7. Захоронение");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                flours();
                break;
            case "2":
                showPlaces();
                break;
            case "3":
                showPlaces();
                break;
            case "4":
                vskritie();
                break;
            case "5":
                krem();
                break;
            case "6":
                fire();
                break;
            case "7":
                horon();
                break;
        }
    }

    @Override
    protected void flours() {
        ArrayList<String> flour = new ArrayList<>();
        flour.add("1. Ромашки - 78 рублей");
        flour.add("2. Подсолнух - 150 рублей");
        flour.add("3. Гипсофилы - 700 рублей");
        System.out.println(flour);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.println("Ромашки поставили, будьте спокойны");
                break;
            case "2":
                System.out.println("Подсолнух поставили, будьте спокойны");
                break;
            case "3":
                System.out.println("Гипсофилы поставили, будьте спокойны");
                break;
        }
        my_log.logger.info("Flowers are installed");
    }

    @Override
    protected void showPlaces() {
        System.out.println("Выберите место для уборки могилы:");
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                System.out.print(places[i][j] + " ");
            }
            System.out.println();
        }
        cleanGrave();
        my_log.logger.info("Place was destroyed");
    }

    @Override
    protected void cleanGrave() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер места для уборки:");
        int selectedPlace = scanner.nextInt();

        if (selectedPlace >= 1 && selectedPlace <= 9) {
            int row = (selectedPlace - 1) / 3;
            int col = (selectedPlace - 1) % 3;

            places[row][col] = 0;
            System.out.println("Могила номер " + selectedPlace + " убрана.");
        } else {
            System.out.println("Некорректный номер места.");
        }
        my_log.logger.info("Grave was cleaned");
    }

    @Override
    protected void vskritie() {
        System.out.print("Введите имя человека, которого вы хотите вскрыть: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        vskrit.add(answer + " Вскрыт успешно");
        my_log.logger.info("Vskritie proshlo uspeshno");
    }

    @Override
    protected void krem() {
        System.out.print("Введите имя человека, которого вы хотите кремировать: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        kremc.add(answer + " Кремирован успешно");
        my_log.logger.info("proshlo uspeshno");
    }

    @Override
    protected void fire() {
        System.out.print("Введите имя ведьмы, которую вы хотите сжечь: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        firee.add(answer + " Ведьма сожжена успешно, все будет хорошо");
        my_log.logger.info("Witch was DESTROYED");
    }

    @Override
    protected void horon() {
        System.out.print("Введите место для захоронения\n");
        for (int i = 0; i < places.length; i++) {
            System.out.println(java.util.Arrays.toString(places[i]));
        }
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                places[0][0] = 0;
                break;
            case "2":
                places[0][1] = 0;
                break;
            case "3":
                places[0][2] = 0;
                break;
            case "4":
                places[1][0] = 0;
                break;
            case "5":
                places[1][1] = 0;
                break;
            case "6":
                places[1][2] = 0;
                break;
            case "7":
                places[2][0] = 0;
                break;
            case "8":
                places[2][1] = 0;
                break;
            case "9":
                places[2][2] = 0;
                break;
        }
        System.out.print("Вы заняли место, посмотрите:\n");
        for (int i = 0; i < places.length; i++) {
            System.out.println(java.util.Arrays.toString(places[i]));
        }
        my_log.logger.info("Place bilo zaneto");
    }

    @Override
    protected void exitCemetery() {
        System.out.println("Вы успешно вышли из кладбища");
    }
}

class Main {
    public static void main(String[] argues) {
        Cemetry cemetery = new Cemetry();
        cemetery.enterCemetery();
    }
}