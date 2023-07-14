package org.mazhuang

static def dateFormat(value) {
    return Date.parse('yyyy年MM月dd日', value).format('yyyy-MM-dd')
}

static def orValue(value1, value2) {
    String tmp = value1 ?: value2; return tmp == null ? null : tmp.replaceAll('[^A-Z0-9]', '');
}

println(dateFormat("2023年12月31日"))

println(orValue("（AA123）", null))

println(orValue(null, "（BB456）"))

println(orValue("（AA123）", "（BB456）"))