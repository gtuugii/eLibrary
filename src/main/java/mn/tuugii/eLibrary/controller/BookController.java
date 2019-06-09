package mn.tuugii.eLibrary.controller;

import mn.tuugii.eLibrary.domain.Book;
import mn.tuugii.eLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/elibrary/book")

public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value={"/list"})
    public ModelAndView books(){
        List<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("book/booklist");
        return modelAndView;
    }

    @GetMapping(value={"/edit"})
    public String edit(Model model){
        model.addAttribute("book", new Book());
        return "book/bookedit";
    }

    @GetMapping(value={"/add"})
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book/bookedit";
    }

    @PostMapping(value={"/edit"})
    public String edit(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "book/bookedit";
        }
        bookService.save(book);
        return "redirect:/elibrary/book/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findOne(id));
        return "book/bookedit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        bookService.delete(id);
        return "redirect:/elibrary/book/list";
    }
}
