# Frameworks

* Runtime Java 15
* Micronaut with underlying Netty  

# Performance investigation

System configuration is
- Windows 10 1909
- CPU Core i7-7700k
- RAM totally 32 GB
- Database target drive was SSD  with measured performance:
```  
  Random Read 4KiB (Q= 32,T= 1) :   306.266 MB/s [ 74772.0 IOPS]
 Random Write 4KiB (Q= 32,T= 1) :   288.849 MB/s [ 70519.8 IOPS]
```

##REST service stub
Jersey was tested vs applied  `src/test/resources/performance-test.jmx` JMeter scenario.
32 threads, 3200000 requests

Implementation | Throughput, requests/sec | CPU, % | RAM, MB  
 --- | ---: | ---: | ---:
Micronaut-Netty Sync | 51710 | 57 | 682
Micronaut-Netty Async | 49690 | 59 | 525
Quarkus Sync | 36110 | 60 | 420
Quarkus Async | 33808 | 61 | 440 
Vertx Async | 49640 | 15 | 366
Grizzly Sync | 57168 | 49 | 357


