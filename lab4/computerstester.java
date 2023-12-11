package lab4;
public class computerstester {
    public static void main(String[] args) {
        computers.Processor processor1 = new computers.Processor("Intel", "Core i7", 3.5);
        computers.Memory memory1 = new computers.Memory(16, "DDR4");
        computers.Monitor monitor1 = new computers.Monitor("Dell", 27, "2560x1440");
        computers.Computer computer1 = new computers.Computer(computers.ComputerBrand.Dell, processor1, memory1, monitor1);
        computers.Processor processor2 = new computers.Processor("AMD", "Ryzen", 4);
        computers.Memory memory2 = new computers.Memory(32, "LDDR4");
        computers.Monitor monitor2 = new computers.Monitor("Lenovo", 30, "2560x1080");
        computers.Computer computer2 = new computers.Computer(computers.ComputerBrand.Dell, processor2, memory2, monitor2);

        System.out.println(computer1);
        System.out.println();
        System.out.println(computer2);
    }
}
