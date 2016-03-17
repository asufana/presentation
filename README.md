
# Presentation Helper

## How to use

### 1. Maven download

pom.xml

```xml
<dependency>
  <groupId>com.github.asufana</groupId>
  <artifactId>presentation</artifactId>
  <version>1.2</version>
</dependency>
```

play1-dependencies.yml

```yaml
require:
    - play
    - com.github.asufana -> presentation [1.0,)

repositories:
    - github:
        type:   iBiblio
        root:   https://raw.github.com/asufana/presentation/mvn-repo/
        contains:
            - com.github.asufana -> *

```

### 2. Add 'Presentation' interfase

```java
public class SomeEntity implements Presentation {
...
}
```

### 3. Generate table html

```java
Entity entity = new SomeEntity(...);
String html = entity.toHtml();
```

## Generated html

### Target classes

```bash
.
├── SomeEntity.java
└── vo
    ├── dept
    │   ├── Dept.java
    │   ├── DeptId.java
    │   └── DeptName.java
    └── employee
        ├── EmpId.java
        ├── EmpName.java
        ├── Employee.java
        ├── FirstName.java
        └── LastName.java
```

### Generated html with default layout

```html
<table class="table table-bordered table-condensed">
  <tr><th>employee.empId.value</th><td>999</td></tr>
  <tr><th>employee.empName.lastName.value</th><td>Hanafusa</td></tr>
  <tr><th>employee.empName.firstName.value</th><td>Makoto</td></tr>
  <tr><th>dept.deptId.value</th><td>100</td></tr>
  <tr><th>dept.deptName.value</th><td>営業</td></tr>
</table>
```

### Generated html with custom layout and @View annotation

```String layout = "employee.empId\n employee.empId\n employee.empName.lastName, employee.empName.firstName\n employee.deptName";```

```html
<table class="table table-bordered table-condensed">
  <tr>
    <th class="xxx">社員番号</th><td>1</td>
  </tr>
  <tr>
    <th>社員番号</th><td>1</td>
  </tr>
  <tr>
    <th>姓</th><td>Hanafusa</td>
    <th>名</th><td>Makoto</td>
  </tr>
  <tr>
    <th>部署名</th><td>null</td>
  </tr>
</table>
```

