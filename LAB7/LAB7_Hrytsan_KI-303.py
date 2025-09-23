import sys
#Ввід розміру квадратної  матриці і символа заповнювача, ініціалізація списку, який буде нашою матрицею
rows_num = int(input("Введіть розмір квадратної матриці: "))
lst = []
filler = input("Введіть символ-заповнювач: ")
#Створення порожніх рядків (списків всередині матриці)
for i in range(rows_num):
    lst.append([])
#Перевірка чи веденно один символ заповнювач 
if len(filler) == 1:
#Заповнює матрицю символом заповнювачем, якщо розмір матриці паре число
    if(rows_num%2==0):
        for i in range(rows_num//2):
            for j in range((i+1)*2):
                lst[i].append(filler)
                lst[rows_num-1-i].append(filler)
#Заповнює матрицю символом заповнювачем, якщо розмір матриці непарне число
    else:
        for j in range(rows_num):
            lst[rows_num//2].append(filler)
        for i in range(rows_num//2):
            for j in range((i+1)*2):
                lst[i].append(filler)
                lst[rows_num-1-i].append(filler)
#Переривання роботи програми якщо не веденно символа заповнювача
elif len(filler) == 0:

    print("Не введено символ-заповнювач")
    sys.exit(1) 
#Переривання роботи програми якщо ведено більше ніж 1 символ заповнювач
else:
    print("Забагато символів-заповнювачів")
    sys.exit(1)
#Вивід матриці на екран відповідно до варіанту 
for i in range(rows_num):
    L=len(lst[i])
    left =L//2
    spaces =rows_num-L
    for j in range (left):
        print(lst[i][j], end='')  
    if(spaces>0):
        print(' '*spaces, end='')
    for j in range(left,L):
        print(lst[i][j], end='')
    print()




    


         
     
         
                   

    


    