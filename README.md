# ⚡️ Spring + Native + Cache - GraalVM Performance Lab

This straightforward guide shows how I migrated to GraalVM, validated dependencies, configured reflection, and achieved real performance gains using JMeter and build optimizations.

A high-performance application built with Spring Boot 3.4.x and Caffeine cache, optimized with GraalVM Native Image. 

This project demonstrates how to reduce startup time, CPU, and memory usage dramatically, achieving up to **35x faster startup**, **over 86% less CPU**, and **50% less memory**.

> 📘 This project is explained in detail on the blog:  
> **"5 simple steps that will eliminate cold starts and high CPU in cloud-native Java apps"**  
> 👉 [Read the article here](https://seu-blog.com/spring-native-bff-performance)

---

## 🚀 Results

| Metric              | JVM (.jar)   | Native Image | Gain             |
|---------------------|--------------|---------------|------------------|
| Startup Time        | 1.86s        | 0.052s        | **35.8x faster** |
| CPU Usage (avg)     | 15%          | 2%            | **86.6% less**   |
| Memory Usage (avg)  | 0.8%         | 0.4%          | **50% less**     |

---

## 🔧 How to Run

### 1. Clone the repo

```bash
git clone https://github.com/pedrocarrijo95/spring-native-cache.git
cd spring-native-cache
```
### 2. Add reflection configurations
```bash
mvn clean package
java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar target/your-app.jar
```

### 3. Build the project and Generate the native executable with AOT (Ahead-of-Time - GraalVM required)

```bash
mvn clean package -Pnative
```

### 4. Run the native binary

```bash
cd target
./spring-native-cache
```

## 📦 Requirements
- GraalVM JDK 21+
- Maven 3.9+
- Spring Boot 3.4+

## 📈 Features
- ✅ Spring Boot (@RestController)
- ✅ Caffeine Cache
- ✅ Native Image build
- ✅ CPU, Memory & Startup optimizations
- ✅ Structure ready for PGO (Profile-Guided Optimization)
- ✅ Performance comparison friendly (JMeter + top)

## 📈 Contribute
Feel free to fork, test with Redis or Prometheus, or even adapt for your own use cases.
