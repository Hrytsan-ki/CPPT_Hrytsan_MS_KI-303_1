import sys
rows_num = int(input("Введіть розмір квадратної матриці: "))
lst = []
filler = input("Введіть символ-заповнювач: ")
for i in range(rows_num):
    lst.append([])
if len(filler) == 1:
    if(rows_num%2==0):
        for i in range(rows_num//2):
            for j in range((i+1)*2):
                lst[i].append(filler)
                lst[rows_num-1-i].append(filler)
    else:
        for j in range(rows_num):
            lst[rows_num//2].append(filler)
        for i in range(rows_num//2):
            for j in range((i+1)*2):
                lst[i].append(filler)
                lst[rows_num-1-i].append(filler)
elif len(filler) == 0:

    print("Не введено символ-заповнювач")
    sys.exit(1) 
else:
    print("Забагато символів-заповнювачів")
    sys.exit(1)
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




    


         
     
         
                   

    


    