<h1 align="center">Привет, я <a href="#" target="_blank">Nikita!</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
<h3 align="center">Выпускник факультета Компьютерных Наук, Java разработчик из Казахстана</h3>

<h2>Инструкции по запуску</h2>
<div>
<p>1)Откройте консоль в папке в которую вы хотите скачать проект и клонируйте туда репозиторий с помощью команды</p>
  
```
git clone https://github.com/Nikita333111/Library-MVC.git
```

<p>Откройте проект в среде разработки.</p>
<p>Создайте базу данных в PostgreSql и назначьте ей имя, после этого вставьте необходимые конфигурационные данные в файл hibernate.properties как показанно ниже</p>
![image](https://github.com/Nikita333111/Library-MVC/assets/118007966/eae41d33-5391-4c45-9141-73bde379724c)

</div>

2)Если вы хотите другой commit (не финальную версию - spring data jpa), нужно проделать следующие шаги:   
Написать в консоль следующую команду:

```
git log
```

Она выведет три commit'a из которых вы выбираете желаемый и копируете его ключ
Для отката к нужному коммиту используется команда

```
git checkout ...
```

где вместо точек вставляется SSH ключ желаемого коммита.


<h2>Описание реализованных функции</h2>
Реализованы сущности (@Entity) Книга и Человек, репозитории и сервисы.
<ul>
<li>Добавлена пагинация для книг.
Книг может быть много и они могут не помещаться на одной странице в
браузере. Чтобы решить эту проблему, метод контроллера умеет
выдавать не только все книги разом, но и разбивать выдачу на страницы. Для этого на странице "/books" нужно указать параметры "?page=0&books_per_page=3" </li>
<li>Добавлена сортировка книг по году. Для этого на странице "/books" нужно указать параметр "?sort_by_year=true" </li>
<li> Создана страница поиска книг. Вводим в поле на странице начальные буквы
названия книги, получаем список книг с именами авторов (jpa repository). Также, если
книга сейчас находится у кого-то, получаем имя этого человека. </li>
<li>Добавлена автоматическая проверку на то, что человек просрочил возврат
книги. - Работа с датами. </li>
</ul>
