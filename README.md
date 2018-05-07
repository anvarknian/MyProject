# MyProject


## Описание

Есть таблица с двумя полями Id и Timestamp, где
 Id- возрастающая последовательность, каждая вставка новой записи в таблицу приводит к
генерации ID(n)=ID(n-1) + 1
 Timestamp – временная метка, в стандартном процессе текущее время, при вставке
задним числом может принимать любые значения меньше максимума времени всех
предыдущих записей
Вставка задним числом – операция вставки записи в таблицу при которой
ID(n) > ID(n-1)
Timestamp(n) < max(timestamp(1):timestamp(n-1))



## Пример таблицы

Это лишь пример для наглядности. Набор данных может отличаться как по содержимому так
и по объему.


Id Timestamp
1 2016.09.11
2 2016.09.12
3 2016.09.13
4 2016.09.14
5 2016.09.09 [Вставказадним числом]
6 2016.09.08 [Вставказадним числом]
7 2016.09.15



## Задача

Написать код (если нет опыта со scala или sql, то на любом языке), который будет возвращать
список всех id, подходящих под определение вставки задним числом. Нужно только
решение. Например, таблицу можно сделать в виде стандартной коллекции, работу с бд
реализовывать не требуется.
