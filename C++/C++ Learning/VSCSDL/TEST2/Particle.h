#pragma once
#include <SDL.h>
#include <iostream>

class Particle {
private:
	int x;
	int y;
	const int SCREEN_WIDTH;
	const int SCREEN_HEIGHT;
	int speed;
	int size;
public:
	Particle();
	Particle(int x, int y, int r, int sw, int sh);
	friend std::ostream& operator<<(std::ostream& os, const Particle& particle);
	void move(int deltaX, int deltaY);
	void move(float theta);
	void renderFilled(SDL_Renderer* renderer);
	void render(SDL_Renderer* renderer);
	int getX();
	int getY();
	int getSize();
	int getSpeed();
	void setX(int x);
	void setY(int y);
	void setSize(int r);
	void setSpeed(int s);
};

//cout << particle.getX() << " " << particle.getY();
