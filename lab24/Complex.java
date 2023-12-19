package lab24;

// Complex.java
// Это интерфейс, который определяет методы для работы с комплексными числами (числами вида a + bi).
// Методы getReal() и getImage() возвращают действительную и мнимую части комплексного числа соответственно.
public interface Complex {
    double getReal();
    double getImage();
    String toString(); // Метод toString() используется для представления комплексного числа в виде строки.
}
