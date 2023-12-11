package lab4;
public class computers {
    // Перечисление для брендов компьютеров
    enum ComputerBrand {
        ASUS, HP, Dell, Lenovo, Acer
    }

    // Класс для описания проца
    static class Processor {
        private final String brand;
        private final String model;
        private final double clockSpeedGHz;

        public Processor(String brand, String model, double clockSpeedGHz) {
            this.brand = brand;
            this.model = model;
            this.clockSpeedGHz = clockSpeedGHz;
        }

        @Override
        public String toString() {
            return brand + " " + model + ", Clock Speed: " + clockSpeedGHz + " GHz";
        }
    }

    // Класс для ОЗУ
    static class Memory {
        private final int capacityGB;
        private final String memoryType;

        public Memory(int capacityGB, String memoryType) {
            this.capacityGB = capacityGB;
            this.memoryType = memoryType;
        }

        @Override
        public String toString() {
            return "Capacity: " + capacityGB + " GB, Type: " + memoryType;
        }
    }

    // Класс для описания монитора
    static class Monitor {
        private final String brand;
        private final int sizeInches;
        private final String resolution;

        public Monitor(String brand, int sizeInches, String resolution) {
            this.brand = brand;
            this.sizeInches = sizeInches;
            this.resolution = resolution;
        }

        @Override
        public String toString() {
            return brand + " Monitor, Size: " + sizeInches + " inches, Resolution: " + resolution;
        }
    }

    // Класс для описания компьютера
    static class Computer {
        private final ComputerBrand brand;
        private final Processor processor;
        private final Memory memory;
        private final Monitor monitor;

        public Computer(ComputerBrand brand, Processor processor, Memory memory, Monitor monitor) {
            this.brand = brand;
            this.processor = processor;
            this.memory = memory;
            this.monitor = monitor;
        }

        @Override
        public String toString() {
            return "Computer Brand: " + brand + "\nProcessor: " + processor + "\nMemory: " + memory + "\nMonitor: " + monitor;
        }
    }
}
