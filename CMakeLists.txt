cmake_minimum_required(VERSION 3.27)
project(utp_project1_final)

set(CMAKE_CXX_STANDARD 20)

add_library(utp_project1_final SHARED TicTakToe.cpp
)

target_include_directories(utp_project1_final PRIVATE
        "C:/Users/lenovo/OneDrive/Belgeler/jdk-23.0.1/include"
        "C:/Users/lenovo/OneDrive/Belgeler/jdk-23.0.1/include/win32"
)


target_include_directories(utp_project1_final PRIVATE
        "C:/Users/lenovo/IdeaProjects/utpp1final/src/Main"

)

target_link_options(utp_project1_final PRIVATE -static)