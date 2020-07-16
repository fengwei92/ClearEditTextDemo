# ClearEditTextDemo
一键清除所有内容
## 使用方式:
1.主项目build.gradle中添加
```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  2.在app目录的build.gradle中添加
  ```
  dependencies {
	        implementation 'com.github.fengwei92:ClearEditTextDemo:Tag'
	}
  ```
  3.在xml文件中添加
  ```
  <com.fengw.cleareditlibrary.ClearEditText
    android:layout_width='match_parent'
    android:layout_height='40dp'
    ....
  />
  ```
  具体样式自行修改
