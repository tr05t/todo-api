# todo-api

Repositories:

- https://github.com/Eddy1015/todo-app
- https://github.com/Eddy1015/todo-api

---

Simple Java Spring App providing a REST API.

## Quickstart

- Starting a database instance:
    ```shell
    docker-compose -f ./docker/docker-compose-mariadb.yml up -d
    ```


- Starting a [Keycloak](https://www.keycloak.org/) instance:
    ```shell
    docker-compose -f ./docker/docker-compose-keycloak.yml up -d
    ```

  - Logging in into admin console of Keycloak: 
    - http://127.0.0.1/8090
    - username: `admin` 
    - password: `Pa55w0rd`
  - Import client config from [docker/realm-export.json](docker/realm-export.json) 
  - Add a user
    - Set `Email verified` to true
    - Set `Password` (Credentials)
    - Add role `todo-user` (Role Mappings --> Realm Roles)
    

- Starting [frontend app (https://github.com/Eddy1015/todo-app)](https://github.com/Eddy1015/todo-app)
    ```shell
    nx run to-do-list:serve:development
    ```
  - http://127.0.0.1:4200
  - click `Login` and enter credentials of the user you set up in Keycloak