package ornicar.scalalib

import org.joda.time.{ DateTime ⇒ JodaDateTime }
import java.util.Date

trait DateTime {

  implicit final class ornicarDateTime(date: JodaDateTime) {
    def getSeconds: Long = date.getMillis / 1000
    def getDate: Date = date.toDate
  }

  implicit def ornicarDateTimeOrdering: Ordering[JodaDateTime] =
    new Ordering[JodaDateTime] {
      def compare(a: JodaDateTime, b: JodaDateTime) =
        org.joda.time.DateTimeComparator.getInstance.compare(a, b)
    }
}
