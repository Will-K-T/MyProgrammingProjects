#include "VectorField.h"

VectorField::VectorField(int rows, int cols): rows(rows), cols(cols){
	field = createVectorField(rows, cols);
}

Vector**& VectorField::createVectorField(int rows, int cols){
	bool fail = false;
	Vector** f = new Vector*[rows];

	for (size_t row = 0; row < rows; row++) {
		f[row] = new Vector[cols];
		if(f[row] == nullptr){
			fail = true;
			break;
		}
		for (size_t col = 0; col < cols; col++) {
			f[row][col] = Vector::getCartesianVector(0, 1);
		}
	}

	if (fail) {
		for (size_t row = 0; row < rows; row++) {
			delete[] f[row];
		}
		delete[] f;
		f = nullptr;
	}

	return f;
}

void VectorField::updateVector(int row, int col, Vector o) {
	field[row][col] = o;
}

Vector& VectorField::getVector(int row, int col) {
	return field[row][col];
}

Vector**& VectorField::getVectorField() {
	return field;
}

int VectorField::getRows() {
	return rows;
}

int VectorField::getCols() {
	return cols;
}