#define STUDENTS 5                                            
#define SUBJECTS 4                                            
#include <string.h>                                             
main()                                                          
    {                                                               
    char name[STUDENTS][20];                                    
    int marks[STUDENTS][SUBJECTS+1];                   
    printf("Input students names & their marks in four subjects\n");
    get_list(name, marks, STUDENTS, SUBJECTS);                  
    get_sum(marks, STUDENTS, SUBJECTS+1);                       
    printf("\n");                                               
    print_list(name,marks,STUDENTS,SUBJECTS+1);                 
    get_rank_list(name, marks, STUDENTS, SUBJECTS+1);           
    printf("\nRanked List\n\n");                                
    print_list(name,marks,STUDENTS,SUBJECTS+1);
    }                                                               
    // Input student name and marks
    get_list(char *string[ ],                                  
    int array [ ] [SUBJECTS +1], int m, int n)  {
        int   i, j, (*rowptr)[SUBJECTS+1] = array;                  
        for(i = 0; i < m; i++)                                      
        {                                                           
        scanf("%s", string[i]);                                  
        for(j = 0; j < SUBJECTS; j++)                            
        scanf("%d", &(*(rowptr + i))[j]);                     
        }                                                           
        }   
    /Compute total marks obtained by each student/
    get_sum(int array [ ] [SUBJECTS +1], int m, int n){                                                               
        int   i, j, (*rowptr)[SUBJECTS+1] = array;                  
        for(i = 0; i < m; i++)                                      
        {
        (*(rowptr + i))[n-1] = 0;                                
        for(j =0; j < n-1; j++)                                  
        ((rowptr + i))[n-1] += ((rowptr + i))[j];           
    }                                                           
    }                                                               
    /Prepare rank list based on total marks/
    get_rank_list(char *string [ ],                                 
    int array [ ] [SUBJECTS + 1]                     
    int m, int n                                   
    {                                                               
    int i, j, k, (*rowptr)[SUBJECTS+1] = array;                 
    char *temp;                                                 
    for(i = 1; i <= m-1; i++)                                   
    for(j = 1; j <= m-i; j++)                                
    if( ((rowptr + j-1))[n-1] < ((rowptr + j))[n-1]) {                                                    
        swap_string(string[j-1], string[j]);                
        for(k = 0; k < n; k++)                              
            swap_int(&((rowptr + j-1))[k],&((rowptr+j))[k]);
        }                                                     
    }                                                               
    /Print out the ranked list/
    print_list(char *string[ ],                                 
    int array [] [SUBJECTS + 1],                      
    int m, int n                                      
    {                                                               
    int i, j, (*rowptr)[SUBJECTS+1] = array;                   
    for(i = 0; i < m; i++)                                      
    {                                                           
    printf("%-20s", string[i]);                              
    for(j = 0; j < n; j++)                                   
    printf("%5d", (*(rowptr + i))[j]);                    
    printf("\n");                                         
    }                                                           
    }                                                               
    /Exchange of integer values/
    swap_int(int *p, int *q)                                
    {                                                               
    int temp;                                                  
    temp = *p;                                                  
    *p   = *q;                                                  
    *q   = temp;                                                
    }   
    /Exchange of strings/
    swap_string(char s1[ ], char s2[ ])                    
    {                                                               
    char swaparea[256];                                        
    int   i;                                                    
    for(i = 0; i < 256; i++)                                    
    swaparea[i] = '\0';                                      
    i = 0;                                                      
    while(s1[i] != '\0' && i < 256)                             
    {                                                           
    swaparea[i] = s1[i];                                     
    i++;                                                     
    }                                                           
    i = 0;                                                      
    while(s2[i] != '\0' && i < 256)                             
    {                                                           
    s1[i] = s2[i];                                           
    s1[++i] = '\0';                                          
    }                                                           
    i = 0;                                                      
    while(swaparea[i] != '\0')                                  
    {                                                           
    s2[i] = swaparea[i];                                     
    s2[++i] = '\0';                                          
    }                                                           
    }