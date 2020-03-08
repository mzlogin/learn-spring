package org.mazhuang.base64test;

/**
 * author: mazhuang
 * date: 2020/3/8
 */
public class CustomBase64Encoder {

    /**
     * 索引表
     */
    private static final char[] sBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'
    };

    /**
     * 将 byte[] 进行 Base64 编码并返回字符串
     * @param src 原文
     * @return 编码后的字符串
     */
    public static String encode(byte[] src) {
        if (src == null) {
            return null;
        }

        byte[] dst = new byte[(src.length + 2) / 3 * 4];

        int index = 0;

        // 每次将 3 个字节编码为 4 个字节
        for (int i = 0; i < (src.length / 3 * 3); i += 3) {
            int bits = (src[i] & 0xff) << 16 | (src[i + 1] & 0xff) << 8 | (src[i + 2] & 0xff);
            dst[index++] = (byte) sBase64[(bits >>> 18) & 0x3f];
            dst[index++] = (byte) sBase64[(bits >>> 12) & 0x3f];
            dst[index++] = (byte) sBase64[(bits >>> 6) & 0x3f];
            dst[index++] = (byte) sBase64[bits & 0x3f];
        }

        // 处理剩下的 1 个或 2 个字节
        if (src.length % 3 == 1) {
            int bits = (src[src.length - 1] & 0xff) << 4;
            dst[index++] = (byte) sBase64[(bits >>> 6) & 0x3f];
            dst[index++] = (byte) sBase64[bits & 0x3f];
            dst[index++] = '=';
            dst[index] = '=';
        } else if (src.length % 3 == 2) {
            int bits = (src[src.length - 2] & 0xff) << 10 | (src[src.length - 1] & 0xff) << 2;
            dst[index++] = (byte) sBase64[(bits >>> 12) & 0x3f];
            dst[index++] = (byte) sBase64[(bits >>> 6) & 0x3f];
            dst[index++] = (byte) sBase64[bits & 0x3f];
            dst[index] = '=';
        }

        return new String(dst);
    }

    public static void main(String[] args) {
        System.out.println(encode("cat".getBytes()));
        System.out.println(encode("c".getBytes()));
        System.out.println(encode("ca".getBytes()));
    }
}
