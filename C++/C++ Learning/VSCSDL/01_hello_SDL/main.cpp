//Includes
#include "SimplexNoise.h"
#include "VectorField.h"
#include "Particle.h"
#include <SDL.h>
#include <iostream>
#include <stdio.h>

//Screen dimension constants
//const int SCREEN_WIDTH = 640;
//const int SCREEN_HEIGHT = 480;
const static int SCREEN_WIDTH = 1920;
const static int SCREEN_HEIGHT = 1080;

//Global Variables used in loop
const int sqSize = 40;
const float inc = 0.1f;
const float shift = 0.01f;
const int timeStep = 250;
float x = 0.f;
float y = 0.f;
float prevX = x;
float prevY = y;
SimplexNoise noise(.7f, 1.f, 2.f, .5f);
VectorField vectorField(SCREEN_HEIGHT/sqSize, SCREEN_WIDTH/sqSize);
Particle test(10, 10, 10, SCREEN_WIDTH, SCREEN_HEIGHT);

//Starts up SDL and creates window
bool init();
//Loads media
bool loadMedia();
//Loops until the program closes
void loop();
//Frees media and shuts down SDL
void close();

void drawPerlinNoise2D();

void drawVectorField();

void SDL_RenderFilledCircle(SDL_Renderer* renderer, int xc, int yc, int r);

void SDL_RenderDrawCirlce(SDL_Renderer* renderer, int xc, int yc, int r);

void updateVectorField();
void updateParticle();

//The window we'll be rendering to
SDL_Window* gWindow = NULL;
//The surface contained by the window
SDL_Surface* gScreenSurface = NULL;
//The renderer
SDL_Renderer* gRenderer = NULL;

int main(int argc, char* args[])
{
    if (!init()) {
        printf("Failed to initialize!\n");
    }
    else {
        if(!loadMedia()){
            printf( "Failed to load media!\n" );
        }
        else {
            //Main loop flag
            bool quit = false;
            SDL_Event e;

            while (!quit) {
                while (SDL_PollEvent(&e)) {
                    if (e.type == SDL_QUIT) {
                        quit = true;
                    }
                    if (e.type == SDL_KEYDOWN) {
                        switch (e.key.keysym.sym) {
                        case SDLK_p:
                            bool loop = true;
                            SDL_Event f;
                            while (loop) {
                                while (SDL_PollEvent(&f)) {
                                    if (f.type == SDL_KEYDOWN) {
                                        switch (f.key.keysym.sym) {
                                        case SDLK_p:
                                            loop = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                //Clears the renderer with the color black
                SDL_SetRenderDrawColor(gRenderer, 0, 0, 0, SDL_ALPHA_OPAQUE);
                SDL_RenderClear(gRenderer);

                //Update the image
                SDL_SetRenderDrawColor(gRenderer, 255, 255, 255, SDL_ALPHA_OPAQUE);
                loop();

                //Update the surface
                //SDL_UpdateWindowSurface(gWindow);

                //Renders the renderer to the screen
                SDL_RenderPresent(gRenderer);

                SDL_Delay(1);
            }
        }
    }
    //Free resources and close SDL
    close();
	return 0;
}

bool init()
{
    //Initialization flag
    bool success = true;

    //Initialize SDL
    if( SDL_Init( SDL_INIT_VIDEO ) < 0 )
    {
        printf( "SDL could not initialize! SDL_Error: %s\n", SDL_GetError() );
        success = false;
    }
    else
    {
        //Create window
        gWindow = SDL_CreateWindow( "SDL Tutorial", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_SHOWN );
        gRenderer = SDL_CreateRenderer(gWindow, -1, SDL_RENDERER_ACCELERATED);
        if( gWindow == NULL )
        {
            printf( "Window could not be created! SDL_Error: %s\n", SDL_GetError() );
            success = false;
        }
        else
        {
            //Get window surface
            gScreenSurface = SDL_GetWindowSurface( gWindow );
        }
    }

    return success;
}

bool loadMedia()
{
    //Loading success flag
    bool success = true;

    //testing

    //loop();
    return success;
}

void loop() {
    //drawPerlinNoise2D();
    //drawVectorField();
    //updateVectorField();
    //updateParticle();
    SDL_RenderFilledCircle(gRenderer, 960, 540, 50);
}

void close()
{
    //Deallocate surface
    SDL_FreeSurface( gScreenSurface );
    gScreenSurface = NULL;

    //Destroy window
    SDL_DestroyWindow( gWindow );
    gWindow = NULL;

    //Destroy renderer
    SDL_DestroyRenderer(gRenderer);
    gRenderer = NULL;

    //Quit SDL subsystems
    SDL_Quit();
}

void drawVectorField() {
    for (int row = 0; row < vectorField.getRows(); row++) {
        for (int col = 0; col < vectorField.getCols(); col++) {
            Vector& curr = vectorField.getVector(row, col);
            int x1 = col*sqSize+sqSize/2;
            int y1 = row*sqSize+sqSize/2;
            int x2 = x1+static_cast<int>(curr.getX()/curr.getMag()*sqSize/2);
            int y2 = y1+static_cast<int>(curr.getY()/curr.getMag()*sqSize/2);
            SDL_RenderDrawLine(gRenderer, x1, y1, x2, y2);
        }
    }
}

void updateVectorField() {
    for (int row = 0; row < vectorField.getRows(); row++) {
        for (int col = 0; col < vectorField.getCols(); col++) {
            Vector& curr = vectorField.getVector(row, col);
            curr.changeAngle(1.0/timeStep);
            curr.setMag(2);
        }
    }
}

void updateParticle() {
    test.renderFilled(gRenderer);
    int nearestRow = test.getY()/sqSize;
    int nearestCol = test.getX()/sqSize;
    Vector closestVector = vectorField.getVector(nearestRow, nearestCol);
    //std::cout << closestVector.getX() << " : " << closestVector.getY() << std::endl;
    //test.move(closestVector.getX(), closestVector.getY());
    std::cout << test;
    test.setSpeed(2);
    test.move(closestVector.getAngle());
}

void drawPerlinNoise2D() {
    //Loading the tiles with the current xOff and yOff
    SDL_Rect currRect;
    y = prevY;
    for (int row = 0; row < SCREEN_WIDTH; row += sqSize) {
        x = prevX;
        for (int col = 0; col < SCREEN_HEIGHT; col += sqSize) {
            currRect.x = row;
            currRect.y = col;
            currRect.w = sqSize;
            currRect.h = sqSize;
            int val = map(noise.fractal(16, x, y), -1, 1, 0, 255);
            SDL_FillRect(gScreenSurface, &currRect, SDL_MapRGB(gScreenSurface->format, val, val, val));
            //SDL_SetRenderDrawColor(gRenderer, val, val, val, SDL_ALPHA_OPAQUE);
            //SDL_RenderFillRect(gRenderer, &currRect);
            x += inc;
        }
        y += inc;
    }
    prevX += shift;
    prevY += shift;
}

void SDL_RenderFilledCircle(SDL_Renderer* renderer, int xc, int yc, int r) {
    int x = 0;
    int y = r;
    int f = 1-r;
    while (x < y) {
        
        if (f<0) {
            f += 2*x+1;
        }
        else {
            f += 2*(x-y+1);
            y--;
        }

        SDL_RenderDrawLine(renderer, xc-x, yc+y, xc+x, yc+y);
        SDL_RenderDrawLine(renderer, xc-x, yc-y, xc+x, yc-y);
        SDL_RenderDrawLine(renderer, xc-y, yc+x, xc+y, yc+x);
        SDL_RenderDrawLine(renderer, xc-y, yc-x, xc+y, yc-x);
        x++;
    }
}

void SDL_RenderDrawCirlce(SDL_Renderer* renderer, int xc, int yc, int r) {
    int x = 0;
    int y = r;
    int f = 1-r;
    while (x < y) {
        
        if (f<0) {
            f += 2*x+1;
        }
        else {
            f += 2*(x-y+1);
            y--;
        }
        
        SDL_RenderDrawPoint(renderer, xc+x, yc+y);
        SDL_RenderDrawPoint(renderer, xc+x, yc-y);
        SDL_RenderDrawPoint(renderer, xc-x, yc+y);
        SDL_RenderDrawPoint(renderer, xc-x, yc-y);

        SDL_RenderDrawPoint(renderer, xc+y, yc+x);
        SDL_RenderDrawPoint(renderer, xc+y, yc-x);
        SDL_RenderDrawPoint(renderer, xc-y, yc+x);
        SDL_RenderDrawPoint(renderer, xc-y, yc-x);
        x++;
    }
}