#pragma once

#include "Vector.h"
#include <cstddef>

class VectorField {
private:
	Vector** field;
	int rows, cols;
public:
	VectorField(int rows, int cols);
	Vector**& createVectorField(int rows, int cols);
	void updateVector(int row, int col, Vector o);
	Vector& getVector(int row, int col);
	Vector**& getVectorField();
	int getRows();
	int getCols();
};
