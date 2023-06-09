# План по проверке и автоматизации тестирования приложения «Мобильный хоспис»

## Определение объекта тестирования

Объектом тестирования является мобильное приложение «Мобильный хоспис» для Android.

## Описание объекта тестирования

Приложение даёт функционал по работе с претензиями хосписа и включает в себя:

1.  информацию о претензиях и функционал для работы с ними
2.  новостную сводку хосписа
3.  тематические цитаты

## Определение границ приложения

Приложение состоит из следующих частей:

1. Навигационная панель (позволяет переключаться между экранами)
2. Рабочая область выбранного экрана
3. Экран загрузки
4. Форма входа в аккаунт.

Навигационная панель состоит из нескольких элементов:

1. Кнопка "Меню" (иконка "Бургерное меню")
2. Кнопка "Тематические цитаты" (иконка "Бабочка")
3. Кнопка выхода (иконка "Портрет")

В меню доступны следующие вкладки:

1. Главная
2. Претензии
3. Новости
4. О приложении

## План проверки приложения

1. Проверка экрана авторизации
2. Проверка экрана "Главная":

- [x] Блок новостей
- [x] Блок претензий
- [x] Выход на экран авторизации

3. Проверка экрана "Новости"

- [x] Функционал для редактирования новостей

4. Проверка экрана "Претензии"

- [x] Функционал для редактирования претензий

5. Проверка экрана "Панель управления"
6. Проверка экрана "О приложении"
7. Проверка экрана "Тематические цитаты"

- [x] Функционал для работы с цитатами

8. Проверка выхода из учетной записи

## Инструменты для тестирования

1. Git-hub - для хранения кода и автотестов.
2. Android Studio - Среда разработки для работы с платформой Android.
3. Android API 29 - API-интерфейс платформы, который приложения могут использовать для взаимодействия с базовой системой Android.
4. Java - язык программирования для написания автотестов.
5. Gradle - система автоматической сборки проектов на Java.
6. UI Automator - набор инструментов для написания автоматизированного функционального тестирования UI.
7. Espresso -тестовый фреймворк с открытым исходным кодом, разработанный Google. Он позволяет писать тесты по принципу белого и серого ящика. Позволяет выполнять сложные тесты пользовательского интерфейса на реальном устройстве или эмуляторе.
8. Allure - это инструмент для построения понятных отчётов автотестов.

## Возможные риски

1. Утечка информации из базы данных.
2. Невозможность автоматизации в виду изменения базы данных.
3. Увеличение затрат при написании автотестов.
4. Невозможность протестировать приложение на всех девайсах.
5. Увеличение сроков тестирования.

## Оценка затраченного времени

100 - 120 часов.

## План сдачи работ

1. Исследование приложения - 18.04.2023
2. Составление предварительной документации - до 25.04.2023
3. Написание автотестов - до 10.05.2023
4. Подготовка отчетной документации - до 16.05.2023
