import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans
import random

# add support for n number of clusters using an array to be the available indexes
def pickRandCentroids():
    indx1 = random.randint(0, len(testData))
    indx2 = random.randint(0, len(testData))
    while indx1 == indx2:
        indx1 = random.randint(0, len(testData))
        indx2 = random.randint(0, len(testData))
    return testData[indx1], testData[indx2]

t1 = -1 + -4 * np.random.rand(50, 2)
t2 = 1 + 4 * np.random.rand(50, 2)
testData = np.concatenate((t1, t2), axis=0)

kMean = KMeans(n_clusters=2)
kMean.fit(testData)

centers = kMean.cluster_centers_

myCentroids = pickRandCentroids()

plt.scatter(testData[:, 0], testData[:, 1], c='b')

# Scikit centroids
plt.scatter(centers[0, 0], centers[0, 1], s=200, c='g', marker='s')
plt.scatter(centers[1, 0], centers[1, 1], s=200, c='r', marker='s')

# My centroids
plt.scatter(myCentroids[0][0], myCentroids[0][1], s=15, c='g')
plt.scatter(myCentroids[1][0], myCentroids[1][1], s=15, c='r')

plt.show()
