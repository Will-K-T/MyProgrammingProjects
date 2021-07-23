#include "Vector.h"

Vector::Vector() {
	x = 0;
	y = 0;
	angle = 0;
	mag = 0;
}

Vector::Vector(float x, float y) {
	this->x = x;
	this->y = y;
	angle = atan(y/x);
	mag = sqrt(x*x + y*y);
}

Vector Vector::getCartesianVector(float angle, float mag) {
	float x = mag * cos(angle);
	float y = mag * sin(angle);
	return Vector(x, y);
}

std::ostream& operator<<(std::ostream& os, const Vector& vec) {
	os << "<" << vec.x << ", " << vec.y << ">" << std::endl;
	return os;
}

float Vector::getAngle() {
	return this->angle;
}

float Vector::getMag() {
	return this->mag;
}

float Vector::getX() {
	return x;
}

float Vector::getY() {
	return -1*y;
}

void Vector::setAngle(float angle) {
	this->angle = angle;
	x = mag * cos(angle);
	y = mag * sin(angle);
}

void Vector::setMag(float mag) {
	this->mag = mag;
	x = mag * cos(angle);
	y = mag * sin(angle);
}

void Vector::changeAngle(float delta) {
	angle += delta;
	x = mag * cos(angle);
	y = mag * sin(angle);
}