import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scala.io.Source

/**
  * Есть таблица с двумя полями Id и Timestamp, где
  * iD          - возрастающая последовательность, каждая вставка новой записи в таблицу приводит к
  * генерации iD(n)=iD(n-1) + 1
  * timestamp   – временная метка, в стандартном процессе текущее время, при вставке
  * задним числом может принимать любые значения меньше максимума времени всех предыдущих записей
  * Вставка задним числом – операция вставки записи в таблицу при которой
  * iD(n) > iD(n-1)
  * timestamp(n) < max(timestamp(1):timestamp(n-1))
  *
  *
  *
  * Задача
  * Написать код (если нет опыта со scala или sql, то на любом языке), который будет возвращать
  * список всех iD, подходящих под определение вставки задним числом. Нужно только
  * решение. Например, таблицу можно сделать в виде стандартной коллекции, работу с бд
  * реализовывать не требуется.
  */


object MyObject extends App {


  // Parsing Resources.txt
  val dateString: List[String] = Source.fromFile("src/main/resources/Resources.txt").getLines.toList
  val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  // Creating new list and inserting our dates. we first sort it and then reverse it once again.
  val timestamp: List[LocalDate] = dateString.map(date => LocalDate.parse(date.toString, dateTimeFormat))
  // Generation a list of sorted numbers that has the length of the timestamp list
  val iD: List[Long] = List.tabulate(timestamp.length)(n => n + 1)
  // Merging our Lists
  val combinedList = iD zip timestamp

  def recursion(n: List[(Long, LocalDate)]): Unit = {
    for (i <- 0 to combinedList.size - 2) {
      if (n(i)._2.isAfter(n(i + 1)._2)) {
        val result = n(i + 1)
        print(result)
      }
    }
  }


  println(recursion(combinedList))


}
