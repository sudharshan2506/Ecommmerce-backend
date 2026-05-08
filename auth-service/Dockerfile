version: '3.8'

services:

  postgres:
    image: postgres:17

    container_name: ecommerce-postgres

    environment:
      POSTGRES_DB: ecommerce
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password

    ports:
      - "5432:5432"