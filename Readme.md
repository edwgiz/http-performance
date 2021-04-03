# Performance investigation

System configuration is
- Windows 10 1909
- Runtime OpenJDK 64-Bit Server VM (15-ea+12-431, mixed mode, sharing),
  with default max heap size 16 GB
- CPU Core i7-7700k
- RAM totally 32 GB
- Target drive: SSD  with measured performance:
```  
  Random Read 4KiB (Q= 32,T= 1) :   306.266 MB/s [ 74772.0 IOPS]
 Random Write 4KiB (Q= 32,T= 1) :   288.849 MB/s [ 70519.8 IOPS]
```

## REST service stub

All REST stubs were tested vs applied  `src/test/resources/performance-test.jmx` JMeter scenario.
32 threads, 3200000 requests

Implementation | Throughput, requests/sec | CPU, % | RAM, MB  
 --- | ---: | ---: | ---:
Rust Actix Async | 71545 | 29 | 5
Micronaut-Netty Sync | 51710 | 57 | 682
Micronaut-Netty Async | 49690 | 59 | 525
Micronaut-Netty Async graalvm-ce-java11 WLS-2 | 28861 | 42 | 959
Micronaut-Netty Async graalvm-ce-java11 native-image\* WLS-2 | 21954 | 59 | 530
Quarkus Sync | 36110 | 60 | 420
Quarkus Async | 33808 | 61 | 440 
Vertx Async | 49640 | 15 | 366
Grizzly Sync | 57168 | 49 | 357
Jersey-Grizzly Sync | 39856 | 60 | 485
Reactor-Netty Async | 52331 | 40 | 1660
Spring-Webflux Async | 36848 | 51 | 475

\* Graalvm native-image built with command
```/usr/lib/jvm/graalvm-ce-java11-20.1.0/bin/native-image --no-fallback -jar micronaut/target/micronaut-1.0.jar```
. Its startup time is 105 ms only.
