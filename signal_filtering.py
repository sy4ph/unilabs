import numpy as np
import math
import tkinter as tk
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure
import matplotlib.pyplot as plt
class Signal:
    """
    Представляет сигнал с различными операциями.

    Атрибуты:
    - length (int): Длина сигнала.
    - upper_bound (int): Верхняя граница для генерации случайных значений.
    - coef (int): Коэффициент для линейного дискретного преобразования.
    - lower_bound (int, optional): Нижняя граница для генерации случайных значений. По умолчанию 0.
    - signal (numpy.ndarray): Данные сигнала.

    Методы:
    - linear_transform(a, b): Применяет линейное преобразование к сигналу.
    - diff(): Вычисляет разницу между максимальным и минимальным значениями сигнала.
    - show_histogram_and_graph(): Отображает гистограмму и график сигнала.
    """

    def __init__(self, length: int = 1000, upper_bound: int = 5, lower_bound: int = 0,coef = 0.27):
        
        self.length = length
        self.upper_bound = upper_bound
        self.lower_bound = lower_bound
        self.coef = coef
        self.signal = np.random.uniform(lower_bound, upper_bound, length)
        self.L = int(math.floor(math.sqrt(self.length)))

    def linear_transform(self):
        """
        Применяет линейное дискретное преобразование к сигналу.

        Возвращает:
        - numpy.ndarray: Отфильтрованный сигнал после линейного дискретного преобразования.
        """
        filtered_signal = [0] * self.length
        filtered_signal[0] = self.upper_bound / 2
        for i in range(1, self.length):
            filtered_signal[i] = ((1 - self.coef) * self.signal[i - 1] + self.coef * self.signal[i])
        self.prev_signal = self.signal
        self.signal = filtered_signal
        return self.signal

    def diff(self):
        """
        Вычисляет разницу между максимальным и минимальным значениями сигнала.

        Возвращает:
        - float: Разница между максимальным и минимальным значениями.
        """
        return (max(self.signal) - min(self.signal)) / math.floor(math.sqrt(self.length))

    def calculate_bins(self):
        """
        Вычисляет интервалы для гистограммы.

        Возвращает:
        - np.ndarray: Интервалы для гистограммы.
        """
        bins = np.zeros(self.L)
        bins[0] = min(self.signal)
        for i in range(self.L):
            bins[i] = bins[i - 1] + self.diff()
        return bins

    def show_histogram_and_graph(self):
        """
        Отображает гистограмму и график сигнала.
        """
        fig, ax = plt.subplots(2)
        fig.suptitle('Сигнал')
        ax[0].plot(self.signal)
        ax[1].hist(self.signal, bins=self.calculate_bins())
        plt.show()
    
    def math_expectation(self):
        """
        Вычисляет математическое ожидание сигнала.

        Возвращает:
        - float: Математическое ожидание.
        """
        return np.mean(self.signal)
    
    def dispersion(self):
        """
        Вычисляет дисперсию сигнала.

        Возвращает:
        - float: Дисперсия.
        """
        return np.var(self.signal)
    
class SignalApp:
    def __init__(self, root, coef = 0.27, length = 1000, upper_bound = 5):
#        Failsafe for the root window if the user closes the window
        root.protocol("WM_DELETE_WINDOW", self.on_close)

        self.root = root
        self.root.title("Signal Filtering")
        self.root.geometry("800x600")

        self.signal = Signal(length, upper_bound, coef)

        self.frame = tk.Frame(self.root)
        self.frame.pack(pady=20)

        self.mean_label = tk.Label(self.frame, text="Mean: ")
        self.mean_label.grid(row=0, column=0, padx=10)

        self.mean_value = tk.Label(self.frame, text="")
        self.mean_value.grid(row=0, column=1, padx=10)

        self.dispersion_label = tk.Label(self.frame, text="Dispersion: ")
        self.dispersion_label.grid(row=1, column=0, padx=10)

        self.dispersion_value = tk.Label(self.frame, text="")
        self.dispersion_value.grid(row=1, column=1, padx=10)

        self.plot_frame = tk.Frame(self.root)
        self.plot_frame.pack(pady=20)

        self.fig , self.ax = plt.subplots(2)
        
        self.button_transform = tk.Button(self.frame, text="Linear Transform", command=self.linear_transform)
        self.button_transform.grid(row=2, column=0, columnspan=2, pady=10, padx=10, ipadx=100)

        self.button_clear = tk.Button(self.frame, text="Clear", command=self.clear)
        self.button_clear.grid(row=3, column=0, columnspan=2, pady=10, padx=10, ipadx=100)

        self.button_exit = tk.Button(self.frame, text="Exit", command=self.root.quit)
        self.button_exit.grid(row=4, column=0, columnspan=2, pady=10, padx=10, ipadx=100)

        self.canvas = FigureCanvasTkAgg(self.fig, master=self.plot_frame)
        self.canvas.draw()
        self.canvas.get_tk_widget().pack()

        self.update_mean_dispersion()
        self.update_plot()
    def update_mean_dispersion(self):
        mean = self.signal.math_expectation()
        dispersion = self.signal.dispersion()

        self.mean_value.config(text=str(mean))
        self.dispersion_value.config(text=str(dispersion))

    def update_plot(self):
        self.ax[0].plot(self.signal.signal)
        self.ax[1].hist(self.signal.signal, bins=self.signal.calculate_bins())
        self.canvas.draw()

    def linear_transform(self):
        self.signal.linear_transform()
        self.update_mean_dispersion()
        self.update_plot()

    def on_close(self):
        self.root.quit()

    def clear(self):
        self.ax[0].clear()
        self.ax[1].clear()
        self.update_plot()
class InputApp():
    def __init__(self, root):

        root.protocol("WM_DELETE_WINDOW", self.on_close)

        self.root = root
        self.root.title("Input")
        self.root.geometry("800x600")
        
        self.frame = tk.Frame(self.root)
        self.frame.pack(pady=20)
        
        self.label_length = tk.Label(self.frame, text="Length: ")
        self.label_length.grid(row=0, column=0, padx=10)
        
        self.entry_length = tk.Entry(self.frame)
        self.entry_length.grid(row=0, column=1, padx=10)
        self.entry_length.insert(0, "1000")

        self.label_upper_bound = tk.Label(self.frame, text="Upper Bound: ")
        self.label_upper_bound.grid(row=1, column=0, padx=10)
        
        self.entry_upper_bound = tk.Entry(self.frame)
        self.entry_upper_bound.grid(row=1, column=1, padx=10)
        self.entry_upper_bound.insert(0, "5")

        self.label_transform_coefficient = tk.Label(self.frame, text="Transform Coefficient: ")
        self.label_transform_coefficient.grid(row=3, column=0, padx=10)

        self.entry_transform_coefficient = tk.Entry(self.frame)
        self.entry_transform_coefficient.grid(row=3, column=1, padx=10)
        self.entry_transform_coefficient.insert(0, "0.27")

        self.button_generate = tk.Button(self.frame, text="Generate", command=self.generate)
        self.button_generate.grid(row=4, column=0, columnspan=2, pady=10, padx=10, ipadx=100)
        
        self.button_exit = tk.Button(self.frame, text="Exit", command=self.root.quit)
        self.button_exit.grid(row=5, column=0, columnspan=2, pady=10, padx=10, ipadx=100)
    def on_close(self):
        self.root.quit()
    def generate(self):
        length = int(self.entry_length.get())
        upper_bound = int(self.entry_upper_bound.get())
        coef = float(self.entry_transform_coefficient.get())   
         
        self.signal_app = SignalApp(tk.Toplevel(self.root), coef, length, upper_bound)  # Create a new instance of SignalApp
        self.root.withdraw()
        self.signal_app.root.mainloop()
    
if __name__ == "__main__":
    root = tk.Tk()
    input_app = InputApp(root)
    root.mainloop()





    


