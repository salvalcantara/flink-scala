# flink-scala

A naive attempt for migrating the original [flink-scala](https://github.com/apache/flink/tree/master/flink-scala)
from Scala 2.12 to Scala 2.13, with emphasis on Type Information aspects. In particular, since Flink is becoming [Scala-free](https://flink.apache.org/2022/02/22/scala-free.html)
starting at version 1.15, this project should allow using Scala-specific types in Flink 1.15.

> This project is intented to be used in conjunction with the Java API directly. If you want a Scala API along the
> lines of the current [flink-streaming-scala](https://github.com/apache/flink/tree/master/flink-streaming-scala) module,
> take a look at [flink4s](https://github.com/ariskk/flink4s/blob/main/LICENSE) for an ongoing effort on that direction.

So far, we've followed the discussion in [FLINK-13414](https://issues.apache.org/jira/browse/FLINK-13414) in order to "fix"
the major incompatibilities. Very naively, we have managed to get the project compile, but changes need to be 
properly verified and tested.

Any contributions are more than welcome!