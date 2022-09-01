# qa-guru-14-homework6

## Задание
1. На главной странице GitHub выберите меню Pricing -> Compare Plans с помощью команды hover для Pricing. Убедитесь что загрузилась нужная страница (например что заголовок - "Choose the plan that’s right for you."


2. (Опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()

 - Откройте https://the-tests.github.internet.herokuapp.com/drag_and_drop
 - Перенесите прямоугольник А на место В
 - Проверьте, что прямоугольники действительно поменялись
 - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

3. Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
Этот тест представить в трех вариантах:
- Чистый Selenide (с Listener)
- Лямбда шаги через step (name, () -> {})
- Шаги с аннотацией @Step
