# NotFoundException
## Легенда
Вы развиваете приложение с менеджером товаров, который мы рассматривали на лекции, и решили сделать так, чтобы при попытке удаления несуществующего объекта генерировалось ваше исключение, а не `ArrayIndexOfBoundsException`.

Обратите внимание: это правильный подход, поскольку таким образом вы сообщаете (через генерацию исключения), что это исключение, вписывающееся в вашу логику, а не ошибка программиста.

Исключения являются частью API.

Что нужно сделать:

1. Возьмите проект (мы его писали на одной из предыдущих лекций про наследование) с менеджером, репозиторием и товарами (`Product`, `Book`, `TShirt`)
2. Создайте класс исключения `NotFoundException` отнаследовавшись от `RuntimeException` и реализуйте как минимум конструктор с параметром-сообщением (он будет просто вызывать супер-конструктор предка, см. подсказку)
3. В методе удаления `removeById` сначала проверяйте, есть ли элемент (для этого прямо из метода `removeById` вызывайте метод `findById`: если результат - `null`, тогда выкидывайте исключение `NotFoundException`*)
4. Напишите 2 автотеста на репозиторий: первый должен проверять успешность удаления существующего элемента, второй - генерации `NotFoundException` при попытке удаления несуществующего элемента