#include <SDL.h>
#include <iostream>
#include <cmath>

using namespace std;

SDL_Renderer *renderer;
SDL_Window *window;

class Turtle{
private:
    float heading;
    float x;
    float y;
public:
    Turtle(float x, float y){
        this -> x = x;
        this -> y = y;
        heading = 0.0;
    }

    float forwardX(float distance){
        float deltaX = cos(heading*(float)M_PI/180)*distance;
        x = x+deltaX;
        return x;
    }
    float forwardY(float distance){
        float deltaY = sin(heading*(float)M_PI/180)*distance;
        y = y+deltaY;
        return y;
    }
    void setHeading(float h){
        heading = h;
    }
    void goTo(float x, float y){
        this -> x = x;
        this -> y = y;
    }
    void setX(float x){
        this -> x = x;
    }
    void setY(float y){
        this -> y = y;
    }
    float getX(){
        return this -> x;
    }
    float getY(){
        return this -> y;
    }
    float getHeading(){
        return this -> heading;
    }
};

Turtle turt(300, 300);

void drawTheFlake(int n, float len){
    if(n==0){
        float prevX = turt.getX();
        float prevY = turt.getY();
        SDL_RenderDrawLineF(renderer, prevX, prevY, turt.forwardX(len), turt.forwardY(len));
        return;
    }
    drawTheFlake(n-1, len/3);
    turt.setHeading(turt.getHeading()-60);
    drawTheFlake(n-1, len/3);
    turt.setHeading(turt.getHeading()+120);
    drawTheFlake(n-1, len/3);
    turt.setHeading(turt.getHeading()-60);
    drawTheFlake(n-1, len/3);
}

int main(int argc, char *argv[]) {
    SDL_Init(SDL_INIT_VIDEO);

    window = SDL_CreateWindow("SDLTest", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, 600, 600,SDL_WINDOW_SHOWN);

    renderer = SDL_CreateRenderer(window, -1, 0);

    SDL_SetRenderDrawColor(renderer, 0, 255, 0, 255);

    int n = 0;
    float len = 150;
    float xCord = len/2;
    float yCord = sqrtf(len*len-len/2*len/2)/3;
    float testX = cos(xCord)*sqrtf(len*len-len/2*len/2)/1.5+300;
    float testY = sin(xCord)*sqrtf(len*len-len/2*len/2)/1.5+300;

    //turt.goTo(cos(M_PI/2)*sqrtf(len*len-len/2*len/2)/1.5+300, sin(M_PI/2)*sqrtf(len*len-len/2*len/2)/1.5+300);
    turt.goTo(300 - xCord, 300 - yCord);
    //turt.setHeading(90);
    drawTheFlake(n, len);
    turt.setHeading(turt.getHeading() + 120);
    drawTheFlake(n, len);
    turt.setHeading(turt.getHeading() + 120);
    drawTheFlake(n, len);
    turt.goTo(300, 300);
    turt.setHeading(90);
    SDL_RenderDrawLineF(renderer, 300, 300, turt.forwardX(87), turt.forwardY(87));
    turt.goTo(300, 300);
    turt.setHeading(turt.getHeading()-120);
    SDL_RenderDrawLineF(renderer, 300, 300, turt.forwardX(87), turt.forwardY(87));
    turt.goTo(300, 300);
    turt.setHeading(turt.getHeading()-120);
    SDL_RenderDrawLineF(renderer, 300, 300, turt.forwardX(87), turt.forwardY(87));
    /*
    while(true) {
        turt.goTo(300, 300);
        turt.setHeading(turt.getHeading()+1);
        if(turt.getHeading()<=180) {
            turt.goTo(turt.getX() - xCord, turt.getY() - yCord);
        }
        else{
            turt.goTo(turt.getX() + xCord, turt.getY() + yCord);
        }
        drawTheFlake(n, len);
        turt.setHeading(turt.getHeading() + 120);
        drawTheFlake(n, len);
        turt.setHeading(turt.getHeading() + 120);
        drawTheFlake(n, len);
        SDL_RenderPresent(renderer);
        SDL_Delay(150);
        SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
        SDL_RenderClear(renderer);
        SDL_SetRenderDrawColor(renderer, 0, 255, 0, 255);
    }*/
    /*
    while(true) {
        SDL_SetRenderDrawColor(renderer, 0, 255, 0, 255);

        turt.setHeading(turt.getHeading()+1);
        drawTheFlake(n, len);
        turt.setHeading(turt.getHeading() + 120);
        drawTheFlake(n, len);
        turt.setHeading(turt.getHeading() + 120);
        drawTheFlake(n, len);

        SDL_RenderPresent(renderer);
        SDL_Delay(150);
        SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
        SDL_RenderClear(renderer);
    }*/
    SDL_RenderPresent(renderer);
    float x = 0;
    float y = 1;
    SDL_RenderDrawPointF(renderer, 300, 300);
    while (true) {
        if(x >= 600 || y>=600){
            x = 0;
            y = 0;
        }
        SDL_SetRenderDrawColor(renderer, 0, 255, 0, 255);
        //SDL_RenderDrawPointF(renderer, x, y*sin(x/4)*10+300);
        SDL_RenderDrawPointF(renderer, cos(x)*sqrtf(len*len-len/2*len/2)/1.5+300, sin(x)* sqrtf(len*len-len/2*len/2)/1.5+300);
        /*turt.goTo(cos(x)*sqrtf(len*len-len/2*len/2)/1.5+300, sin(x)* sqrtf(len*len-len/2*len/2)/1.5+300);
        turt.setHeading(cos(x)*90 + sin(x)*90);
        drawTheFlake(n, len);
        turt.setHeading(turt.getHeading() + 120);
        drawTheFlake(n, len);
        turt.setHeading(turt.getHeading() + 120);
        drawTheFlake(n, len);*/
        x += .1;
        y += .001;
        SDL_RenderPresent(renderer);
        SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
        //SDL_RenderClear(renderer);
    }
    SDL_Delay(10000);

    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}