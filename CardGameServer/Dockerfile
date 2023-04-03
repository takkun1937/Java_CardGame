FROM openjdk:17.0.2-slim-bullseye

# Create user
RUN groupadd -r normal_users && \
    useradd -r -g normal_users stone

# Install common tools
RUN apt update && \
    apt -y -qq install curl unzip