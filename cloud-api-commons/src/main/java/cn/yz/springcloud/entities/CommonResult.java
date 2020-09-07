package cn.yz.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName CommonResult
 * @date 2020/8/31 22:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
//        this.code = code;
//        this.message = message;
        this(code,message,null);
    }

}
