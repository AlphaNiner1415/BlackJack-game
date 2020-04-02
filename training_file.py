import random
from BackPropTest import *
results_table = [[15, 7, 0, 1, 0],
[13, 6, 0, 0, 1],
[12, 6, 0, 1, 0],
[18, 9, 1, 0, 0],
[10, 3, 0, 0, 1],
[10, 8, 0, 0, 1],
[17, 10, 0, 0, 1],
[13, 4, 1, 0, 0],
[10, 5, 0, 0, 1],
[6, 7, 0, 0, 1],
[20, 10, 1, 0, 0],
[20, 4, 1, 0, 0],
[18, 10, 0, 0, 1],
[6, 9, 1, 0, 0],
[12, 1, 1, 0, 0],
[20, 9, 0, 1, 0],
[20, 7, 0, 1, 0],
[18, 1, 0, 0, 1],
[17, 3, 0, 0, 1],
[12, 10, 1, 0, 0],
[17, 7, 0, 1, 0],
[13, 9, 1, 0, 0],
[5, 10, 1, 0, 0],
[16, 3, 0, 1, 0],
[16, 3, 0, 1, 0],
[13, 9, 1, 0, 0],
[12, 9, 1, 0, 0],
[18, 10, 0, 1, 0],
[10, 4, 1, 1, 1],
[19, 6, 0, 1, 0],
[14, 6, 1, 0, 0],
[6, 8, 1, 0, 0],
[13, 6, 0, 0, 1],
[17, 3, 1, 0, 0],
[17, 8, 1, 0, 0],
[4, 4, 1, 1, 1],
[18, 9, 0, 0, 1],
[14, 6, 1, 1, 1],
[8, 2, 0, 0, 1],
[4, 5, 1, 0, 0],
[17, 7, 0, 0, 1],
[18, 5, 0, 1, 0],
[7, 8, 0, 1, 0],
[14, 3, 0, 1, 0],
[17, 1, 0, 0, 1],
[11, 4, 0, 0, 1],
[14, 7, 0, 0, 1],
[21, 7, 0, 1, 0],
[10, 6, 1, 0, 0],
[13, 10, 1, 0, 0]]
dataset2 = results_table[40:]
print(len(dataset2))
n_inputs = len(results_table[0]) - 1
n_outputs = len(set([row[-1] for row in results_table]))
random.seed(1)
network = initialize_network(n_inputs, 6, n_outputs)
train_network(network,dataset2, 0.67,60, n_outputs)
#train_network(network, results_table, 0.66, 300, n_outputs)
count = 0
for row in results_table:
    prediction = predict(network, row)
    if(row[-1] == prediction):
        count += 1
    print('Expected=%d, Got=%d' % (row[-1], prediction))
print(count)
