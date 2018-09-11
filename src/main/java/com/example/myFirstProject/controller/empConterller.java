package com.example.myFirstProject.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.myFirstProject.switchMD5;
import com.example.myFirstProject.mode.emp;
import com.example.myFirstProject.service.impl.empServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class empConterller {

	@Autowired
	private empServiceImpl empService;
	
	@RequestMapping(value = "vue", method = {RequestMethod.POST , RequestMethod.GET})
	public String vueTest() {
		return "vue";
	}

	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(emp e, ModelMap modelMap) {
		System.out.println("list.............");
		switchMD5 md5 = new switchMD5();
		String passwd = md5.MD5(e.getPassword());
		System.out.println("转换后的密码： " + passwd);
		e.setPassword(passwd);
		if (empService.getEmpAll(e).size() == 0) {
			System.out.println("没有该用户: " + e.getUser());
			modelMap.put("thisUser", "账号密码错误~请重新输入~");
			return "login";
		}
		return "redirect:/index";
	}
	String x11 = "1";
	@RequestMapping(value = "index", method = { RequestMethod.POST, RequestMethod.GET })
	public String index(ModelMap modelMap ,String currentpage) {
		System.out.println("currentpage: "+currentpage);
		int size = 5;
		if(currentpage != null) {
			x11 = currentpage;
		}
		System.out.println("x11: "+x11);
		List<emp> list = empService.pageList(size,Integer.parseInt(x11));
		modelMap.put("list", list);
		return "index";
	}
	
	@RequestMapping(value="pages" ,method = { RequestMethod.POST ,RequestMethod.GET})
	public String pages(ModelMap modelMap,String currentpage) {
		return "redirect:index";
	}
	

	@RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login() {
		System.out.println("login..............");
		return "login";
	}

	@RequestMapping(value = "uploading", method = { RequestMethod.POST, RequestMethod.GET })
	public String uploading() {
		System.out.println("uploading......");
		return "zyg/uploading";
	}
	// 文件 上传
	@RequestMapping(value = "upPath", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String upPath(MultipartFile mFile, String name) throws Exception {
		/*
		 * r:  只读 -- 文件不存在则会出错
		 * r+: 读写 -- 文件不存在则会出错,写入时,会覆盖源文件
		 * w:  只写 -- 如果文件不存在则创建文件,会覆盖源文件,如果写入内容少则保留为覆盖的内容
		 * w+:                  同上 
		 * a:  只写 -- 如果文件不存在则创建文件,会采用追加模式
		 * a+: 读写 --            同上
		 * b: 二进制读写 -- 
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("name1xx: " + name);
		System.out.println("mFile: " + mFile);
		if (mFile == null || mFile.isEmpty()) {
			map.put("name", "文件内容为空~");
			name = mapper.writeValueAsString(map);
			System.out.println("111111111111" + name);
			return name;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		System.out.println("upPath......");
		File filePath = new File("d:/upZyg/" + sdf.format(new Date()));// 创建文件夹
		if (!filePath.exists()) { // 如果文件夹不存在 就创建文件
			filePath.mkdirs();
		}
		if (filePath.listFiles().length > 0) { // 如果文件夹内存在 数据 就清空掉
			File[] files = filePath.listFiles();
			for (File file : files) {
				file.delete();
			}
		}
		String srcFileName = mFile.getOriginalFilename();
		File dest = new File(filePath, srcFileName); // 获取文件的名字
		try {
			// 实现文件上传(本质上就是文件的复制)
			mFile.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		name = srcFileName + "上传成功，路径为：" + filePath;
		map.put("name", name);
		name = mapper.writeValueAsString(map);
		System.out.println(name);
		return name;
	}

	// 下载
	/*@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFile(String log) throws IOException {
		System.out.println("log..."+log);
		String filePath = "/upZyg/2018/" +"3@6KY}Z0DN3YEP~1LL3WXW1.png" ;
		FileSystemResource file = new FileSystemResource(filePath);
		System.out.println("file.."+file.getFilename());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok().headers(headers).contentLength(file.contentLength())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(new InputStreamResource(file.getInputStream()));
	}*/

	@RequestMapping(value="download",method= {RequestMethod.POST,RequestMethod.GET})
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("download.............");
	    String fileName = "/upZyg/2018/" +"3@6KY}Z0DN3YEP~1LL3WXW1.png";// 设置文件名，根据业务需要替换成要下载的文件名
	    if (fileName != null) {
	        //设置文件路径
	        String realPath = "D://upZyg//2019//";
	        File file = new File(realPath , fileName);
	        if (file.exists()) {
	            response.setContentType("application/force-download");// 设置强制下载不打开
	            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
	            byte[] buffer = new byte[1024];
	            FileInputStream fis = null;
	            BufferedInputStream bis = null;
	            try {
	                fis = new FileInputStream(file);
	                bis = new BufferedInputStream(fis);
	                OutputStream os = response.getOutputStream();
	                int i = bis.read(buffer);
	                while (i != -1) {
	                    os.write(buffer, 0, i);
	                    i = bis.read(buffer);
	                }
	                System.out.println("success");
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                if (bis != null) {
	                    try {
	                        bis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (fis != null) {
	                    try {
	                        fis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	    return null;
	}

}
