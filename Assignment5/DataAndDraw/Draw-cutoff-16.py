import csv
import matplotlib.pyplot as plt


x = []
y = []
  
with open('result1000000-16.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*1000000)
        y.append(float(row[1]))
  
plt.plot(x, y, color = 'g', linestyle = 'dashed',
         marker = 'o',label = "1E6 Array Length")
x = []
y = []
with open('result2000000-16.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*2000000)
        y.append(float(row[1]))
plt.plot(x, y, color = 'r', linestyle = 'dashed',
         marker = 'x',label = "2E6 Array Length")

x = []
y = []
with open('result4000000-16.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*4000000)
        y.append(float(row[1]))
plt.plot(x, y, color = 'b', linestyle = 'dashed',
         marker = '*',label = "4E6 Array Length")

plt.xticks(rotation = 25)
plt.xlabel('CutOff')
plt.ylabel('Time(ms/10)')
plt.title('16 Thread Runtime Report', fontsize = 20)
plt.grid()
plt.legend()
plt.show()