import java.util.*;

public class Main {
    public static void main(String[] args) {

        int listSize, upperBound, filterBound;
        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        while (true){
            System.out.println("Введите размер списка:");
            String strListSize = scanner.nextLine();
            try {
                listSize = Integer.parseInt(strListSize);
                break;
            } catch (NumberFormatException e){
                logger.log("Был введен некорректный размер списка");
                System.out.println("Был введен некорректный размер списка");
            }
        }

        while (true){
            System.out.println("Введите верхнюю границу для значений:");
            String strUpperBound = scanner.nextLine();
            try {
                upperBound = Integer.parseInt(strUpperBound);
                break;
            } catch (NumberFormatException e){
                logger.log("Была введена некорректная граница списка");
                System.out.println("Была введена некорректная граница списка");
            }
        }

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < listSize; i++){
            list.add(random.nextInt(upperBound));
        }
        System.out.println("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");

        while (true){
            System.out.println("Введите порог для фильтра:");
            String strFilterBound = scanner.nextLine();
            try {
                filterBound = Integer.parseInt(strFilterBound);
                break;
            } catch (NumberFormatException e){
                logger.log("Был введен некорректный порог для фильтра");
                System.out.println("Был введен некорректный порог для фильтра");
            }
        }

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterBound);
        List<Integer> result = filter.filterOut(list);
        logger.log("Прошло фильтр " + result.size() + " элемента из " + list.size());
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }
}
