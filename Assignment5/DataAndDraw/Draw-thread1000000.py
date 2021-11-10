import csv
import matplotlib.pyplot as plt

x = []
y = []
  
with open('result1000000-1.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*1000000)
        y.append(float(row[1]))
  
plt.plot(x, y, color = 'c', linestyle = 'dashed',
         marker = '1',label = "1 Thread")

x = []
y = []
  
with open('result1000000-2.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*1000000)
        y.append(float(row[1]))
  
plt.plot(x, y, color = 'm', linestyle = 'dashed',
         marker = '.',label = "2 Thread")

x = []
y = []
  
with open('result1000000-4.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*1000000)
        y.append(float(row[1]))
  
plt.plot(x, y, color = 'g', linestyle = 'dashed',
         marker = 'o',label = "4 Thread")
x = []
y = []
with open('result1000000-8.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*1000000)
        y.append(float(row[1]))
plt.plot(x, y, color = 'r', linestyle = 'dashed',
         marker = 'x',label = "8 Thread")

x = []
y = []
with open('result1000000-16.csv','r') as csvfile:
    lines = csv.reader(csvfile, delimiter=',')
    for row in lines:
        x.append(float(row[0])*1000000)
        y.append(float(row[1]))
plt.plot(x, y, color = 'b', linestyle = 'dashed',
         marker = '*',label = "16 Thread")

plt.xticks(rotation = 25)
plt.xlabel('CutOff')
plt.ylabel('Time(ms/10)')
plt.title('1E6 Array Length Runtime Report', fontsize = 20)
plt.grid()
plt.legend()
plt.show()