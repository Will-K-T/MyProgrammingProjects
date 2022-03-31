#pragma once
#include <math.h>
#include <iostream>

class Vector {
private:
	float angle;
	float mag;
	float x;
	float y;
public:
	Vector();
	Vector(float x, float y);
	static Vector getCartesianVector(float angle, float mag);
	friend std::ostream& operator<<(std::ostream& os, const Vector& vec);
	float getAngle();
	float getMag();
	float getX();
	float getY();
	void setAngle(float angle);
	void setMag(float mag);
	void changeAngle(float delta);
};
