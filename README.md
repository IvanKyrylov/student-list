# Task
Написать приложение на spring webflux. Приложение должно иметь 2 ендпоинта: создать студента и посмотреть список студентов. Для хранения можно использовать любую встроенную БД или в памяти приложения. Необходимо предусмотреть валидацию входных данных. Например:
- возраст студента не может быть пустым и меньше 16
- имя и фамилия студента не могут быть пустыми
валидацию делаете на свое усмотрение
Если валидация не прошла, то надо давать внятный ответ, где можно будет понять что именно не прошло валидацию.
Так же приложение должно иметь тесты, где всё это можно проверить.

# Описание 
Основной url:
`http://localhost:8080/students`
Два метода list(), add().
Вот заготовка post запроса на добавление:
```json{
    "name":"Ivan",
    "surname":"Kyrylov",
    "dateOfBirth":"1997-10-09",
    "phoneNumber": "+38-090-000-00-00",
    "email":"weddd@t.co",
    "address":"Test",
    "course": "1",
    "groupName":"IPZ-22"
}
```
Бд Postgresql, есть миграция.
Вот если что кидайте pull request.
Спасибо.
Слава Омниссии!
