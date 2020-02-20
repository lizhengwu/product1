/**
 * FileName: FirstController
 * Author:   lzw
 * Date:     2020/2/20 16:42
 * Description:
 * History:
 */
package com.lzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
@Controller
public class FirstController {

	@RequestMapping
	@ResponseBody
	public String helloWordByController() {
		return "helloWordByController";
	}
}