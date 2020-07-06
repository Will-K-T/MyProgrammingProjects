cmake_minimum_required(VERSION 3.15)
project(TestingWithSDL)

set(CMAKE_CXX_STANDARD 14)

set(SDL2_INCLUDE_DIR C:\\Users\\thompson_898340\\Documents\\thisneedstowork\\C++Libs\\SDL2-2.0.10\\include\\)
set(SDL2_LIBRARY C:\\Users\\thompson_898340\\Documents\\thisneedstowork\\C++Libs\\SDL2-2.0.10\\lib\\x86\\SDL2.lib
        C:\\Users\\thompson_898340\\Documents\\thisneedstowork\\C++Libs\\SDL2-2.0.10\\lib\\x86\\SDL2main.lib)

include_directories(${SDL2_INCLUDE_DIR})

add_executable(TestingWithSDL main.cpp SDL_Renderer.cpp SDL_Renderer.h)
target_link_libraries(TestingWithSDL ${SDL2_LIBRARY})
