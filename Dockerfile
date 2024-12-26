# Use a base image with Node.js for building the Vue.js project
FROM node:16 as build-stage

# Set the working directory inside the container
WORKDIR /app

# Copy the Vue.js project files
COPY . .

# Install dependencies and build the Vue.js project
RUN npm install && npm run build

# Use an Nginx image to serve the built Vue.js files
FROM nginx:stable-alpine

# Copy the built Vue.js files to the Nginx container
COPY --from=build-stage /app/dist /usr/share/nginx/html

# Expose port 80 for the Nginx server
EXPOSE 80
