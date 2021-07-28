#include "Particle.h"
#include <stdexcept>

Particle::Particle(): SCREEN_WIDTH(0), SCREEN_HEIGHT(0){
	x = 0;
	y = 0;
	size = 0;
    speed = 1;
}

Particle::Particle(int x, int y, int size, int sw, int sh): x(x), y(y), size(size), SCREEN_WIDTH(sw), SCREEN_HEIGHT(sh), speed(1) {
	if(size < 0) throw std::invalid_argument("Particle can not have a negative radius.");
}

std::ostream& operator<<(std::ostream& os, const Particle& p) {
    os << "(" << p.x << ", " << p.y << ")" << std::endl;
    return os;
}

void Particle::move(int deltaX, int deltaY) {
	x = (x+deltaX+SCREEN_WIDTH)%SCREEN_WIDTH;
	y = (y+deltaY+SCREEN_HEIGHT)%SCREEN_HEIGHT;
}

void Particle::move(float theta) {
    /*x = static_cast<int>(x + speed * cos(theta)+SCREEN_WIDTH)%SCREEN_WIDTH;
    y = static_cast<int>(y + speed * -1*sin(theta)+SCREEN_HEIGHT)%SCREEN_HEIGHT;*/
    std::cout << "data: " << x << " " << speed*cos(theta) << std::endl;
    x = lround(x + speed * cos(theta)+SCREEN_WIDTH)%SCREEN_WIDTH;
    y = lround(y + speed * -1*sin(theta)+SCREEN_HEIGHT)%SCREEN_HEIGHT;
}

void Particle::renderFilled(SDL_Renderer* renderer) {
	int nx = 0;
    int ny = size;
    int f = 1-size;
    while (nx < ny) {
        
        if (f<0) {
            f += 2*nx+1;
        }
        else {
            f += 2*(nx-ny+1);
            ny--;
        }

        SDL_RenderDrawLine(renderer, x-nx, y+ny, x+nx, y+ny);
        SDL_RenderDrawLine(renderer, x-nx, y-ny, x+nx, y-ny);
        SDL_RenderDrawLine(renderer, x-ny, y+nx, x+ny, y+nx);
        SDL_RenderDrawLine(renderer, x-ny, y-nx, x+ny, y-nx);
        nx++;
    }
}

void Particle::render(SDL_Renderer* renderer) {
    int nx = 0;
    int ny = size;
    int f = 1-size;
    while (nx < ny) {
        
        if (f<0) {
            f += 2*nx+1;
        }
        else {
            f += 2*(nx-ny+1);
            ny--;
        }
        
        SDL_RenderDrawPoint(renderer, x+nx, y+ny);
        SDL_RenderDrawPoint(renderer, x+nx, y-ny);
        SDL_RenderDrawPoint(renderer, x-nx, y+ny);
        SDL_RenderDrawPoint(renderer, x-nx, y-ny);

        SDL_RenderDrawPoint(renderer, x+ny, y+nx);
        SDL_RenderDrawPoint(renderer, x+ny, y-nx);
        SDL_RenderDrawPoint(renderer, x-ny, y+nx);
        SDL_RenderDrawPoint(renderer, x-ny, y-nx);
        nx++;
    }
}

int Particle::getX() {
    return x;
}

int Particle::getY() {
    return y;
}

int Particle::getSize() {
    return size;
}

int Particle::getSpeed() {
    return speed;
}

void Particle::setX(int x) {
    this->x = x;
}

void Particle::setY(int y) {
    this->y = y;
}

void Particle::setSize(int size) {
    this->size = size;
}

void Particle::setSpeed(int s) {
    speed = s;
}
